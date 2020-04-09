package com.github.zjjfly;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * @author zjjfly
 */
public class NewProcessApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process command = processBuilder.command("bash", "-c", "sleep 3").inheritIO().start();
        //Process转换成ProcessHandle
        ProcessHandle processHandle = command.toHandle();
        ProcessHandle.Info info = processHandle.info();
        //设置进程结束的时候的回调
        processHandle.onExit().thenAccept(p -> System.out.println("Is Process " + p.pid() + " alive? " + p.isAlive()));
        System.out.println("Is Process " + processHandle.pid() + " alive? " + processHandle.isAlive());
        //打印进程信息
        System.out.println("|===========================|");
        System.out.println("|Information On Your Process|");
        System.out.println("|===========================|");
        System.out.println("Process id(PID): " + processHandle.pid());
        System.out.println("Process owner: " + info.user().orElse(""));
        System.out.println("Command: " + info.command().orElse(""));
        String[] arguments = info.arguments().orElse(new String[]{});
        System.out.print("Argument(s): ");
        for (String arg : arguments) {
            System.out.print("\t" + arg);
        }
        System.out.println();
        System.out.println("Command line: " + info.commandLine().orElse(""));
        System.out.println("Start time: " + info.startInstant().orElse(Instant.now()));
        System.out.printf("Runtime  duration: %sms\n", info.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis());
        //列出当前所有进程
        ProcessHandle.allProcesses().limit(10).map(ProcessHandle::info)
                     .forEach(i -> System.out.printf("%s\n", i.command().orElse("---")));
        //终止进程
        processHandle.destroy();
        Thread.sleep(4000L);
    }

}
