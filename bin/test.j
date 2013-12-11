.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;

.field public static i I

.method static editReal(I)V
.limit stack 16
.limit locals 10

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	iload 0
	ldc 1
	isub
	istore 0
	iload 0
	ldc 0
	if_icmpgt L000
	goto L001
L000:

	;CallCodeGenerator
	iload 0
	invokestatic test/editReal(I)V
L001:
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

	;AddCodeGenerator
	ldc 5
	ldc "yes"
	iadd
	putstatic test/i I

	;CallCodeGenerator
	getstatic test/i I
	invokestatic test/editReal(I)V
	return

.end method
