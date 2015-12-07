fun sublists(L) =
	if (L=[]) then [nil]
	else sublists(tl(L))
		@ insertL(hd(L),sublists(tl(L)));