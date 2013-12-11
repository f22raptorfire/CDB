.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;

.field public static i Ljava/lang/String;
.field public static j Ljava/lang/String;
.field public static k I

.method static p(Lwci/runtime/Referencer;Lwci/runtime/Referencer;Lwci/runtime/Referencer;)V
.limit stack 16
.limit locals 10

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0
	invokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 1
	invokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 2
	invokevirtual wci.runtime/Referencer/getIntegerValue()I
	invokevirtual java/io/PrintStream/println(I)V
	aload 0
	ldc "win"
	invokevirtual wci.runtime/Referencer/setValue(Ljava/lang/String;)V
	aload 1
	ldc "true"
	invokevirtual wci.runtime/Referencer/setValue(Ljava/lang/String;)V
	aload 2
	ldc 3
	invokevirtual wci.runtime/Referencer/setValue(I)V
	return

.end method

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
	ldc "fail"
	putstatic test/i Ljava/lang/String;
	ldc "false"
	putstatic test/j Ljava/lang/String;
	ldc 1
	putstatic test/k I
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	new wci/runtime/Referencer
	dup
	getstatic test/i Ljava/lang/String;
	invokenonvirtual wci/runtime/Referencer/<init>(Ljava/lang/String;)V
	aastore
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	aaload
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 1
	new wci/runtime/Referencer
	dup
	getstatic test/j Ljava/lang/String;
	invokenonvirtual wci/runtime/Referencer/<init>(Ljava/lang/String;)V
	aastore
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 1
	aaload
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 2
	new wci/runtime/Referencer
	dup
	getstatic test/k I
	invokenonvirtual wci/runtime/Referencer/<init>(I)V
	aastore
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 2
	aaload
	invokestatic test/p(Lwci/runtime/Referencer;Lwci/runtime/Referencer;Lwci/runtime/Referencer;)V

	;reference unwrap
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 2
	aaload
	invokevirtual wci.runtime/Referencer/getIntegerValue()I
	putstatic test/k I

	;reference unwrap
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 1
	aaload
	invokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;
	putstatic test/j Ljava/lang/String;

	;reference unwrap
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	aaload
	invokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;
	putstatic test/i Ljava/lang/String;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/j Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/k I
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method
