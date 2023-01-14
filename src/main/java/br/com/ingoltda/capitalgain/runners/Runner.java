//package br.com.ingoltda.capitalgain.runners;
//
//import br.com.ingoltda.capitalgain.controllers.CliController;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.ExitCodeGenerator;
//import org.springframework.stereotype.Component;
//import picocli.CommandLine;
//import picocli.CommandLine.IFactory;
//
//@Component
//public class Runner implements CommandLineRunner, ExitCodeGenerator {
//
//    private final IFactory factory;
//
//    private final CliController myCommand;
//
//    private int exitCode;
//
//    public Runner(IFactory factory, CliController myCommand) {
//        this.factory = factory;
//        this.myCommand = myCommand;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        exitCode = new CommandLine(myCommand, factory).execute(args);
//    }
//
//    @Override
//    public int getExitCode() {
//        return exitCode;
//    }
//}