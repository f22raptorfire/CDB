.class public simple
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

	;CDBC init
	new wci/runtime/CDBC
	dup
	ldc ""
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic simple/_database Lwci/runtime/CDBC;
	
	;References init
	bipush 10
	anewarray wci/runtime/Referencer
	putstatic simple/_references [Lwci/runtime/Referencer;
	
	return

.end method
