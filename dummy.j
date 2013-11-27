.class public Program
.super java/lang/Object

.field public static i I
.field public static j F

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

;j = 1.2
	ldc 1.2
	putstatic Program/j F
;i = 8
	ldc 8
	putstatic Program/i I
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic Program/j F
	invokevirtual java/io/PrintStream/println(F)V
	return

.end method
