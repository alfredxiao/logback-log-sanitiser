Purpose
* Sanitise (e.g. mask credit card number) log messages in a generic way
* Works for logback

Approach
* Configure one or two `Converter`s in logback config
* Which intercepts log messages before written to log destination (e.g. file, or stdout)
* Where is the sanitisation happens, log sanitiser, or converters can modify the log messages before log is written.

Todo
* Add more sanitisation as per your organisation's needs
