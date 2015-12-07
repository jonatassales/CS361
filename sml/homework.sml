fun fact n = if n=0 then 1
  else n * fact(n-1);

exception Number of int;

fun f(n) = 
	if (n<0) then raise Number(n)
	else if (n=0) then 1
	else 2*f(n-1);

fun new_fact(a,b,c)=
	if a then b else c*new_fact(a,b,c-1);
