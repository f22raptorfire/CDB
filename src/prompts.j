.class public prompts
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static i I

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	new wci/runtime/CDBC
	dup
	ldc "C:\\Users\\Jason\\Documents\\GitHub\\CDB"
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 0
	putstatic prompts/i I
L000:
	getstatic prompts/i I
	ldc 3
	if_icmplt L001
	goto L002
L001:
	ldc "test"
	invokestatic wci.runtime/CDBC/addToCSV(Ljava/lang/String;)V
	ldc "test"
	invokestatic wci.runtime/CDBC/viewCSV(Ljava/lang/String;)V
	getstatic prompts/i I
	ldc 1
	iadd
	putstatic prompts/i I
	goto L000
L002:
	return

.end method
