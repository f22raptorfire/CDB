.class public test
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static i I
.field public static j I
.field public static s Ljava/lang/String;

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	new wci/runtime/CDBC
	dup
	ldc "C:\\Users\\Jason\\Documents\\GitHub\\CDB"
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 1
	putstatic test/i I
	ldc 4
	putstatic test/j I
	ldc "DEMO!"
	putstatic test/s Ljava/lang/String;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/j I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	getstatic test/j I
	iadd
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/s Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic test/i I
	getstatic test/j I
	if_icmplt L000
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Game over"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	goto L001
L000:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "All's well"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L001:
	ldc 1
	putstatic test/i I
L002:
	getstatic test/i I
	ldc 4
	if_icmplt L003
	goto L004
L003:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic test/i I
	ldc 1
	iadd
	putstatic test/i I
	goto L002
L004:
L005:
	getstatic test/i I
	ldc 0
	if_icmpgt L006
	goto L007
L006:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic test/i I
	ldc 1
	isub
	putstatic test/i I
	goto L005
L007:
L008:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic test/i I
	ldc 1
	iadd
	putstatic test/i I
	getstatic test/i I
	ldc 4
	if_icmplt L008
	return

.end method
