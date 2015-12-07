(* remove list items *)
fun remove(x,L) =
  if (L=[]) then []
  else (if (x=hd(L))
  then remove(x,tl(L))
  else hd(L)::remove(x,tl(L)));

remove(2,[1,2,3,2,4]);