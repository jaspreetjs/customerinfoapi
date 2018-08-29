package com.amazonaws.lambda.customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<RequestObject, ResponseObject> {

	@Override
	public ResponseObject handleRequest(RequestObject request, Context context) {

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			dbConnection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);

			context.getLogger().log("Connection established");

			String query = "select c.CIN, c.Name, ct.Description as CustomerType, c.Address, rc.Name as ResidenceCountry, ic.Name as IncorporationCountry, sic.IndustryClassification\n"
					+ "from CustomerInfo c inner join CustomerTypes ct on c.Type = ct.CustomerType\n"
					+ "inner join CountryCodes rc on c.ResidenceCountry = rc.CountryCode\n"
					+ "left join CountryCodes ic on c.IncorporationCountry = ic.CountryCode\n"
					+ "left join SICCodes sic on c.SICCode = sic.SICCode\n" + "where c.CIN = " + request.getCin();
			statement = dbConnection.createStatement();
			resultSet = statement.executeQuery(query);

			context.getLogger().log("Query Executed");

			if (resultSet.next()) {

				ResponseObject response = new ResponseObject();

				response.setCin(request.getCin());
				response.setName(resultSet.getString("Name"));
				response.setCustomerType(resultSet.getString("CustomerType"));
				response.setAddress(resultSet.getString("Address"));
				response.setResidenceCountry(resultSet.getString("ResidenceCountry"));
				response.setIncorporationCountry(resultSet.getString("IncorporationCountry"));
				response.setIndustryClassification(resultSet.getString("IndustryClassification"));
				response.setQueryStatus("success");

				return response;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		ResponseObject errorResponse = new ResponseObject();
		errorResponse.setCin(request.getCin());
		errorResponse.setQueryStatus("error: customer not found");

		return errorResponse;
	}

}
