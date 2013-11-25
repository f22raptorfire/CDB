.class public dummyname
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

;i = 1
	ldc 1
	istore 0
;i = 8
	ldc 8
	istore 0
;Print the integer in location 0
	getstatic     java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method
