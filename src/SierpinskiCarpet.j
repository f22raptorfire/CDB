.class public SierpinskiCarpet
.super java/lang/Object

.field public static _database Lwci/runtime/CDBC;
.field public static _references [Lwci/runtime/Referencer;

.field public static d I
.field public static depth I
.field public static dim I
.field public static i I
.field public static j I

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
	putstatic SierpinskiCarpet/_references [Lwci/runtime/Referencer;

	;CDBC init
	new wci/runtime/CDBC
	dup
	ldc ""
	invokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V
	putstatic test/_database Lwci/runtime/CDBC;
	ldc 3
	putstatic SierpinskiCarpet/depth I
	ldc 1
	putstatic SierpinskiCarpet/dim I
	ldc 0
	putstatic SierpinskiCarpet/i I
L000:
	getstatic SierpinskiCarpet/i I
	getstatic SierpinskiCarpet/depth I
	if_icmplt L001
	goto L002
L001:
	getstatic SierpinskiCarpet/dim I
	ldc 3
	imul
	putstatic SierpinskiCarpet/dim I

	;AddCodeGenerator
	getstatic SierpinskiCarpet/i I
	ldc 1
	iadd
	putstatic SierpinskiCarpet/i I
	goto L000
L002:
	ldc 0
	putstatic SierpinskiCarpet/i I
L003:
	getstatic SierpinskiCarpet/i I
	getstatic SierpinskiCarpet/dim I
	if_icmplt L004
	goto L005
L004:
	ldc 0
	putstatic SierpinskiCarpet/j I
L006:
	getstatic SierpinskiCarpet/j I
	getstatic SierpinskiCarpet/dim I
	if_icmplt L007
	goto L008
L007:
	getstatic SierpinskiCarpet/dim I
	ldc 3
	idiv
	putstatic SierpinskiCarpet/d I
L009:
	getstatic SierpinskiCarpet/d I
	ldc 0
	if_icmpne L010
	goto L011
L010:
	getstatic SierpinskiCarpet/i I
	getstatic SierpinskiCarpet/d I
	ldc 3
	imul
	irem
	getstatic SierpinskiCarpet/d I
	idiv
	ldc 1
	if_icmpeq L012
	goto L013
L012:
	getstatic SierpinskiCarpet/j I
	getstatic SierpinskiCarpet/d I
	ldc 3
	imul
	irem
	getstatic SierpinskiCarpet/d I
	idiv
	ldc 1
	if_icmpeq L014
	goto L015
L014:
	ldc 0
	putstatic SierpinskiCarpet/d I
L015:
L013:
	getstatic SierpinskiCarpet/d I
	ldc 3
	idiv
	putstatic SierpinskiCarpet/d I
	goto L009
L011:
	getstatic SierpinskiCarpet/d I
	ldc 0
	if_icmpne L016
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "##"
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
	goto L017
L016:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "  "
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
L017:

	;AddCodeGenerator
	getstatic SierpinskiCarpet/j I
	ldc 1
	iadd
	putstatic SierpinskiCarpet/j I
	goto L006
L008:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc ""
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	;AddCodeGenerator
	getstatic SierpinskiCarpet/i I
	ldc 1
	iadd
	putstatic SierpinskiCarpet/i I
	goto L003
L005:
	return

.end method
