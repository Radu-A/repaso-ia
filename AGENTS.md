# repaso-ia

Spring Boot 4.0.6 / Java 17 project. Minimal skeleton — only the boot class and a context-loads test exist.

## Commands

```sh
./mvnw spring-boot:run    # dev server
./mvnw test               # run all tests
./mvnw verify             # test + package (jar in target/)
```

## Notable

- **Spring Boot 4 modular starters** — this project uses the explicit `-webmvc`, `-thymeleaf`, `-validation`, `-data-jpa` (and `-test` variants) rather than the monolithic `-starter-web`. Add dependencies the same way.
- **H2 in-memory DB** (runtime scope). The H2 console is enabled via `spring-boot-h2console`.
- **Package** = `com.github.Radu_A.repaso_ia` (hyphen replaced with underscore because `-` is invalid in Java packages). 
- Strictly separate concerns into standard Spring Boot packages: `model` (or `entity`), `repository`, `service`, and `controller`.
- **Java 17** — no record/pattern-matching lint restrictions; feel free to use modern Java.
- `application.properties` currently only has `spring.application.name=repaso-ia`.
- No CI, no lint/format config, no Thymeleaf templates or JPA entities yet.
- **UI/UX Directive** - views must use Tailwind CSS. The design approach must be strictly minimalist, clean, and modern. Use Tailwind components if possible.
- **Live Reload** - the server will automatically restart whenever Java classes or configuration files are modified and recompiled.
