.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;

.field public static i F

.method static editReal(Lwci/runtime/Referencer;)V
.limit stack 16
.limit locals 10

	ldc 2.3
	fstore 1
	ldc 3
	fstore 2
	aload 0

	;AddCodeGenerator
	ldc 4.5
	aload 1
	fdiv
	aload 2
	fadd
	invokevirtual wci.runtime/Referencer/setValue(F)V
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
	ldc 1.2
	putstatic test/i F

	;CallCodeGenerator
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	new wci/runtime/Referencer
	dup
	getstatic test/i F
	invokenonvirtual wci/runtime/Referencer/<init>(F)V
	aastore
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	aaload
	invokestatic test/editReal(Lwci/runtime/Referencer;)V

	;Reference unwrap
	getstatic test/_references [Lwci/runtime/Referencer;
	ldc 0
	aaload
	invokevirtual wci.runtime/Referencer/getFloatValue()F
	putstatic test/i F
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i F
	invokevirtual java/io/PrintStream/println(F)V
	return

.end method
