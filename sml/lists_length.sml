(* length of a list *)

fun double_list(L) =
	if (L=nil) then 0
	else 2*length(L);

fun no_two_first_elements(L) = 
	if (length(L) <= 2) then []
	else tl(tl(L));

fun add1(L) = 
	if (L = []) then []
	else (hd(L)+1)::add1(tl(L));

(* Using pattern matching *)
fun length(nil) = 0
| length(L) = 1+length(tl(L));
