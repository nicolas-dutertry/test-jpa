# test-jpa
This project shows an issue with Karaf 4.2.0 and JPA.

## Usage

Build the project with Maven :

```sh
mvn install
```

Launch Karaf 4.2.0 and install the project kar :
```sh
karaf@root()> feature:install jpa transaction hibernate jdbc pax-jdbc-hsqldb
karaf@root()> jdbc:ds-create -dn hsqldb -url "jdbc:hsqldb:mem:testdb" -u sa jdbc/testdb
karaf@root()> kar:install mvn:com.dutertry.test.karaf.jpa/test-jpa-kar/1.0.0-SNAPSHOT/kar
```

Execute person:list command :
```sh
karaf@root()> person:list
```

You will see the following error :
```sh
Error executing command: Need active coordination
```

In karaf.log :
```
java.lang.IllegalStateException: Need active coordination
	at org.apache.aries.jpa.support.impl.EMSupplierImpl.get(EMSupplierImpl.java:81) ~[?:?]
	at org.apache.aries.jpa.support.osgi.impl.EmProxy.invoke(EmProxy.java:38) ~[?:?]
	at com.sun.proxy.$Proxy77.createQuery(Unknown Source) ~[?:?]
	at Proxy4c2993b8_dc6f_46b4_8e62_524dc0ad05f5.createQuery(Unknown Source) ~[?:?]
	at com.dutertry.test.karaf.jpa.service.impl.TestRepository.list(TestRepository.java:26) ~[?:?]
	at com.dutertry.test.karaf.jpa.service.impl.TestServiceImpl.list(TestServiceImpl.java:25) ~[?:?]
	at com.dutertry.test.karaf.jpa.cmd.ListPersonCommand.execute(ListPersonCommand.java:24) ~[?:?]
	at org.apache.karaf.shell.impl.action.command.ActionCommand.execute(ActionCommand.java:84) ~[?:?]
	at org.apache.karaf.shell.impl.console.osgi.secured.SecuredCommand.execute(SecuredCommand.java:68) ~[?:?]
	at org.apache.karaf.shell.impl.console.osgi.secured.SecuredCommand.execute(SecuredCommand.java:86) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.executeCmd(Closure.java:571) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.executeStatement(Closure.java:497) ~[?:?]
	at org.apache.felix.gogo.runtime.Closure.execute(Closure.java:386) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.doCall(Pipe.java:417) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:229) ~[?:?]
	at org.apache.felix.gogo.runtime.Pipe.call(Pipe.java:59) ~[?:?]
	at java.util.concurrent.FutureTask.run(FutureTask.java:266) ~[?:?]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) ~[?:?]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) ~[?:?]
	at java.lang.Thread.run(Thread.java:748) [?:?]
```
