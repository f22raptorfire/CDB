.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;


.method public <init>()V
.limit stack 1

	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return

.end method

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	;References init:
	bipush 10
	anewarray wci/runtime/Referencer
	putstatic test/_references [Lwci/runtime/Referencer;

	;CDBC init
	new wci/runtime/CDBC
	dup
	ldc ""
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 1
	itof
	ldc 2.2
	fcmpl
	iconst_0
	if_icmplt L000
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Else"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	goto L001
L000:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Then"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L001:
	return

.end method
