.class public controls
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static i I
.field public static j I
.field public static s Ljava/lang/String;

.method public <init>()V
.limit stack 1

	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return

.end method

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	new wci/runtime/CDBC
	dup
	ldc "C:\\Users\\Jason\\Documents\\GitHub\\CDB"
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 1
	putstatic controls/i I
	ldc 4
	putstatic controls/j I
	ldc "DEMO!"
	putstatic controls/s Ljava/lang/String;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "i = "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "j = "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "i + j = "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	iload 1
	iadd
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "s = "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "i < j?"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	iload 0
	iload 1
	if_icmplt L000
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Stuff Broke"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	goto L001
L000:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Yep!"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L001:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "For Loop: From 1 to 3"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	ldc 1
	putstatic controls/i I
L002:
	iload 0
	ldc 4
	if_icmplt L003
	goto L004
L003:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	iload 0
	ldc 1
	iadd
	putstatic controls/i I
	goto L002
L004:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "While Loop: From 4 to 1"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L005:
	iload 0
	ldc 0
	if_icmpgt L006
	goto L007
L006:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	iload 0
	ldc 1
	isub
	putstatic controls/i I
	goto L005
L007:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Do loop: From 0 to 3"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L008:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	iload 0
	ldc 1
	iadd
	putstatic controls/i I
	iload 0
	ldc 4
	if_icmplt L008
	return

.end method
