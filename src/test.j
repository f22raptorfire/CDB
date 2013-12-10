.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static i I
.field public static j I

.method public <init>()V
.limit stack 1

	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return

.end method

.method static p(ILjava/lang/String;)V
.limit stack 16

.limit locals 10

	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/j I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 1
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	return

.end method

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	new wci/runtime/CDBC
	dup
	ldc ""
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 1
	putstatic test/i I
	ldc 3
	putstatic test/j I
	getstatic test/i I
	ldc 1
	iadd
	ldc "4"
	invokestatic test/p(ILjava/lang/String;)V
	return

.end method
