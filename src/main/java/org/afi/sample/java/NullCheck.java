package org.afi.sample.java;

import java.util.Objects;
import java.util.Optional;

// Possible, but only at Runtime
public class NullCheck {

	public static void main(String... args) {
		final var fullName = concatName("José", null, "Silva");
		assert fullName.equals("José Silva");

		try {
			concatName("José", null, null);
			assert false;
		} catch (NullPointerException e) {
			assert "lastName is required".equals(e.getMessage());
		}
	}

	public static String concatName(String firstName, String middleName, String lastName) {
		Objects.requireNonNull(firstName, "firstName is required");
		Objects.requireNonNull(lastName, "lastName is required");
		return String.format("%s %s %s", firstName,
				Optional.ofNullable(middleName).orElse(""),
				lastName);
	}
}
