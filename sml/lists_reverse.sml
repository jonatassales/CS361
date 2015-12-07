(* reverse a list *)
fun reverse(L) = 
	if L = nil then nil
	else reverse(tl(L)) @ [hd(L)];

