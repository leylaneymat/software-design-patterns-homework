# Lab 1 - OmniHome

This project implements the required design patterns for the OmniHome scenario.

## Source structure

Pattern-based folders under:
`software-design-patterns-homework/labs/lab 1/src/main`

- `singleton` - thread-safe `CloudConnection`
- `abstractfactory` - Budget/Luxury families and `DeviceFactory`
- `adapter` - `GlorbThermostat` + `GlorbAdapter`
- `builder` - `AutomationRoutine` + `RoutineBuilder`
- `prototype` - cloneable `Configuration`
- `Main.java` - simulation entry point

JUnit tests are kept in:
`software-design-patterns-homework/labs/lab 1/src/test`

The test suite also includes automatic `.class` cleanup after each test (`src/test/Cleanup.java`).

## Tasks covered in the Main

1. Singleton: two references point to the same `CloudConnection` object.
2. Abstract Factory: creates a Luxury home device set.
3. Adapter: converts Celsius to Fahrenheit for legacy `GlorbThermostat`.
4. Builder: builds "Movie Night" and "Vacation Mode" routines.
5. Prototype: clones configuration and changes cloned IP independently.

## Testing

Tests in this project are unit tests. Current coverage is 96.00% (line coverage, excluding `Main`).

Run tests:

```bash
mvn test
```

Coverage is calculated by JaCoCo using: LINE_COVERED / (LINE_COVERED + LINE_MISSED) * 100.

For a basic visual report regarding coverage, run `mvn clean verify` and open:
`software-design-patterns-homework/labs/lab01/target/site/jacoco/index.html`