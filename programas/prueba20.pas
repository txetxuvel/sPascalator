program prueba20;

CONST
 
  msgMenu='Seleccione una opci�n del men�: 
     1-. Suma
     2-. Resta
     3-. Multiplicaci�n
     4-. Divisi�n
     5-. M�dulo

     0-. Salir';
  msgEjecutando='Ejecuntado opci�n: ';
  msgOpcion='Su opci�n es: ';
  msgResultado='. El resultado es: ';
  msgOperando1='Introduza el primer operando: ';
  msgOperando2='Introduza el segundo operando: ';
  msgOpcionNoValida='La opci�n seleccionada no es v�lida';
  msgSalto='
';

  OFIN=0;
  OSUMA=1;
  ORESTA=2;
  OPRODUCTO=3;
  ODIVISION=4;
  OMODULO=5;

var
   operando1,operando2:integer;
   opcion:integer;

procedure suma(operando1, operando2:integer);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(operando1+operando2);
   write(msgSalto);
end;

procedure resta(x,y:integer);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(operando1-operando2);
   write(msgSalto);
end;

procedure producto(x,y:integer);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(x*y);
   write(msgSalto);
end;

procedure division(x,y:integer);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(x DIV y);
   write(msgSalto);
end;

procedure modulo(x,y:integer);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(x MOD y);
   write(msgSalto);
end;

procedure menu(var opcion:integer);

begin
   write(msgMenu);
   write(msgSalto);
   write(msgOpcion);
   read(opcion);
end;

begin
   menu(opcion);
   while opcion <> OFIN
   DO BEGIN
      if (opcion > OFIN) AND (opcion <= OMODULO)
      THEN BEGIN
         write(msgSalto);
         write(msgOperando1);
         read(operando1);
         write(msgOperando2);
         read(operando2);
         if opcion=OSUMA THEN
            suma(operando1,operando2)
         else
            if opcion=ORESTA THEN
               resta(operando1,operando2)
            else 
               if opcion=OPRODUCTO THEN
                  producto(operando1,operando2)
               else
                  if opcion=ODIVISION THEN
                     division(operando1,operando2)
                  else
                     if opcion=OMODULO THEN
                        modulo(operando1,operando2);
      END
      else
         write(msgOpcionNoValida);    
      write(msgSalto);
      menu(opcion);
   END
end.
