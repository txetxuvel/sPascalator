program prueba21;

CONST
 
  msgMenu='Seleccione una opción del menú: 
     1-. Suma
     2-. Resta
     3-. Multiplicación
     4-. División
     5-. Módulo

     0-. Salir';
  msgEjecutando='Ejecuntado opción: ';
  msgOpcion='Su opción es: ';
  msgResultado='. El resultado es: ';
  msgOperando1='Introduza el primer operando: ';
  msgOperando2='Introduza el segundo operando: ';
  msgOpcionNoValida='La opción seleccionada no es válida';
  msgSalto='
';

  OFIN=0;
  OSUMA=1;
  ORESTA=2;
  OPRODUCTO=3;
  ODIVISION=4;
  OMODULO=5;

var
   operando1,operando2:real;
   opcion:integer;

procedure suma(operando1, operando2:real);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(operando1+operando2);
   write(msgSalto);
end;

procedure resta(x,y:real);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(operando1-operando2);
   write(msgSalto);
end;

procedure producto(x,y:real);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(x*y);
   write(msgSalto);
end;

procedure division(x,y:real);

begin
   write(msgEjecutando);
   write(opcion);
   write(msgResultado);
   write(x DIV y);
   write(msgSalto);
end;

procedure modulo(x,y:real);

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
   operando1:=2.5;
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
