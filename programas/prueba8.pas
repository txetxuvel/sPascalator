program prueba8;

const

   N=5;
   N2=N*N;
   FACTOR1=0.8;
   FACTOR2=FACTOR1+N2;

var
   primera: integer;
   segunda: real;

begin

   primera:=3+4;
   primera:=3+4*7;
   primera:=(3+4)*7;
   primera:=((3+4)*7) MOD 3;
   primera:=7 * 5 DIV 5;
   
   segunda:=3.0+4.0;
   segunda:=3.0+4.0+7.0;
   segunda:=(3.0+4.0)*7.0;
   segunda:=7.0*5.0 DIV 5.0;
   segunda:=3 * 45.67 - 8 DIV 6;

end.