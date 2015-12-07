(* duplicate a list *)
fun duplicate(L) = 
	if (L = nil) then nil
	else [hd(L)]@[hd(L)]@duplicate(tl(L));

(* split a list *)
(* fun split(L) = 
  if length(L) mod 2 = 0 then 
  else [3]; *)

(* flip a list *)
fun flip(L) = 
  if (L=nil) then nil 
  else [hd(tl(L))]@[hd(L)]@flip(tl(tl(L)));

type coords = real * real * real;

open Math;

fun distance(a,b) = 
	sqrt(pow(#1(a:coords) - #1(b:coords),2.0) + pow(#2(a:coords) - #2(b:coords),2.0) + pow(#3(a:coords) - #3(b:coords),2.0)); 