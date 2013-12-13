.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static i I

.method public <init>()V
.limit stack 1

	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return

.end method

;CHANGED THE PARAMETER AND METHOD PROCEDURE

.method static p(Lwci/runtime/Referencer;)V
.limit stack 16
.limit locals 10

	aload 0
	ldc 2
	invokestatic wci.runtime/Referencer/setValue(I)V
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
	
	;NEW CODE STARTS HERE
	
	new wci/runtime/Referencer
	dup
	dup
	getstatic test/i I
	invokenonvirtual wci/runtime/Referencer/<init>(I)V
	invokestatic test/p(Lwci/runtime/Referencer;)V
	invokestatic wci.runtime/Referencer/getIntegerValue()I
	putstatic test/i I
	
	;NEW CODE ENDS HERE
	
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method
