package org.afi.sample.java;

import java.util.Objects;

public class NullCheck {

	public static void main(String... args) {
		final String fullName = concatName("José", "Silva");
		assert fullName.equals("José Silva");

		try {
			concatName("José", null);
			assert false;
		} catch (NullPointerException e) {
			assert "lastName is required".equals(e.getMessage());
		}
	}

	public static String concatName(String firstName, String lastName) {
		Objects.requireNonNull(firstName, "firstName is required");
		Objects.requireNonNull(lastName, "lastName is required");
		return String.format("%s %s", firstName, lastName);
	}
}
