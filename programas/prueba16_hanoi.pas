program pruebaHanoi;


var x:integer;

   procedure CambiarDeTorre (n, t1, t2, tx: integer);

      procedure TrasladarAnillo (ti, tj: integer);

      begin

          write (ti);
          write (tj)

      end;

   begin

      if n > 0 then
         begin
             CambiarDeTorre(n-1, t1, tx, t2);
             TrasladarAnillo(t1,t2);
             CambiarDeTorre(n-1, tx, t2, t1);
          end;
    end;

    begin

         read(x);
         CambiarDeTorre (x, 1, 3, 2) 

     end.