import * as fs from 'fs';

enum LogLevel {
    INFO,
    WARNING,
    ERROR
}

interface ConsoleLogWriter {
    logToConsole(logEntry: string): void;
}

class ConsoleLogger implements ConsoleLogWriter {
    logToConsole(logEntry: string): void {
        console.log(logEntry);
    }
}

interface FileLogWriter {
    logToFile(logEntry: string): void;
}

class FileLogger implements FileLogWriter {
    logToFile(logEntry: string): void {
        fs.appendFile('logs.txt', logEntry + '\n', (err) => {
            if (err) {
                console.error('Error writing to log file:', err);
            }
        });
    }
}

class Logger {
    private static loggerInstance: Logger;
    private consoleLogger: ConsoleLogWriter;
    private fileLogger: FileLogWriter;

    private constructor(consoleLogger: ConsoleLogWriter, fileLogger: FileLogWriter) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
    }

    public static getLoggerInstance(): Logger {
        if (!Logger.loggerInstance) {
            const consoleLogger = new ConsoleLogger();
            const fileLogger = new FileLogger();
            Logger.loggerInstance = new Logger(consoleLogger, fileLogger);
        }
        return Logger.loggerInstance;
    }

    private log(level: LogLevel, message: string, color: string): void {
        const timestamp = new Date().toISOString();
        const logEntry = `${color}[${LogLevel[level]}] ${timestamp} : ${message}\x1b[0m`;
        this.consoleLogger.logToConsole(logEntry);
        this.fileLogger.logToFile(logEntry);
    }

    public info(message: string): void {
        this.log(LogLevel.INFO, message, '\x1b[32m');
    }

    public warning(message: string): void {
        this.log(LogLevel.WARNING, message, '\x1b[33m');
    }

    public error(message: string): void {
        this.log(LogLevel.ERROR, message, '\x1b[31m');
    }
}

// Usage:
const logger = Logger.getLoggerInstance();
logger.info('This is an information message.');
logger.warning('This is a warning message.');
logger.error('This is an error message.');
