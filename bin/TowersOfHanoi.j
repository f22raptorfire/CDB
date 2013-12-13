.class public TowersOfHanoi
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;


.method static move(IIII)V
.limit stack 16
.limit locals 10

	iload 0
	ldc 0
	if_icmpgt L000
	goto L001
L000:

	;CallCodeGenerator
	iload 0
	ldc 1
	isub
	iload 1
	iload 3
	iload 2
	invokestatic TowersOfHanoi/move(IIII)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Move disk from pole "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/print(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc " to pole "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V

	;CallCodeGenerator
	iload 0
	ldc 1
	isub
	iload 3
	iload 2
	iload 1
	invokestatic TowersOfHanoi/move(IIII)V
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
	putstatic TowersOfHanoi/_references [Lwci/runtime/Referencer;

	;CDBC init
	new wci/runtime/CDBC
	dup
	ldc ""
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;

	;CallCodeGenerator
	ldc 4
	ldc 1
	ldc 2
	ldc 3
	invokestatic TowersOfHanoi/move(IIII)V
	return

.end method
