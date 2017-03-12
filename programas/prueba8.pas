program prueba8;

const
   N=10;
   pi=3.14;

type
   registro=RECORD
	uno,dos:real;
	lleno:boolean
               END;

   validos=ARRAY [4..10] OF boolean;

var
   x,y,z:INTEGER;
   a,b,c:real;
   exito,ok:boolean;

   varios:registro;

   val:validos;

begin

   BEGIN
   x:=2*N;
   y:=(x*4+4 DIV 2)MOD 5; 
   a:= - (pi + 4 * 7.0 + 3 MOD (4.5 +y));
   a:=y;
   END;

   BEGIN
   exito:=a > b = x;
   exito:=x > b = a;
   END;

   BEGIN
   OK:=((a>(b = x))) AND exito;
   END;

   varios.uno:=4 + 5 * 8 - x ;

   val[4+3*8]:=45>32 =85.64;
   ok:= val[7*4]>2 = varios.uno;

(* ERRORES *)
{   varios.uno:=4 > 5 ; }
{   y:=(3 + 4 * x) MOD 4.5; }
{   y:=a; }
{   val[4.4+3*8]:=45>32 =85.64; }

end.