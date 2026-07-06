# Logback Logging Engine

## What is Logback?
**Logback** is the direct successor to the original Log4j 1.x project, developed by the same creator (Ceki Gülcü). It is the default logging engine natively integrated into Spring Boot and is designed from the ground up to implement the SLF4J API natively without wrapper overhead.

---

## Key Components in `logback.xml`
1. **Appender:** Specifies the output destination where logs are recorded (e.g., `ConsoleAppender` for terminal STDOUT, `RollingFileAppender` for disk files, or `SocketAppender` for remote servers).
2. **Encoder / PatternLayout:** Formats the raw log message string (e.g., adding `%d{yyyy-MM-dd HH:mm:ss}` timestamp, `%-5level` log severity, `%thread` name, and `%logger` class name).
3. **Logger & Root:** Sets the threshold severity hierarchy (`TRACE` < `DEBUG` < `INFO` < `WARN` < `ERROR`). Messages below the configured threshold are ignored.

---

## Advantages
- **Native SLF4J Implementation:** Because Logback natively implements SLF4J interfaces, there is zero memory or CPU wrapper translation overhead when calling SLF4J loggers.
- **Automatic Reloading:** Logback can scan `logback.xml` for modifications at runtime and reconfigure log levels automatically without restarting the application server!
- **Automatic Compression & File Rotation:** `RollingFileAppender` automatically archives old log files by date/size and compresses them into `.zip` or `.gz` files to prevent server disk overflow.

---

## Disadvantages
- **Lower Peak Throughput than Log4j2:** While extremely fast, Logback's synchronous logging is slightly outperformed by Log4j2's LMAX Disruptor asynchronous ring-buffer logging in extreme high-concurrency trading systems.

---

## Real World Example
- **Microservices Rolling Log Storage:** In a Dockerized production service, Logback is configured with a `RollingFileAppender` that generates an active `app.log` file. Every night at midnight (or whenever the file exceeds 100MB), Logback rolls the file over to `app-2026-07-06.log.gz` and starts a fresh log file automatically.

---

## Interview Questions

### Q1: What is the log level hierarchy in Logback, and how does filtering work?
**Answer:** The hierarchy from lowest to highest severity is: **`TRACE` -> `DEBUG` -> `INFO` -> `WARN` -> `ERROR`**.
If the root logger level is configured to `INFO` in `logback.xml`, any log requests at `TRACE` or `DEBUG` levels are discarded. Only requests at `INFO`, `WARN`, or `ERROR` are printed.

### Q2: How do you prevent log files from consuming all server disk space?
**Answer:** Configure a **`RollingFileAppender`** with a **`SizeAndTimeBasedRollingPolicy`** in `logback.xml`. You set parameters like `<maxFileSize>10MB</maxFileSize>`, `<maxHistory>30</maxHistory>` (keep only 30 days of logs), and `<totalSizeCap>3GB</totalSizeCap>`. Once caps are reached, Logback automatically deletes the oldest archived logs.
