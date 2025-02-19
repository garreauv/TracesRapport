pragma Warnings (Off);
pragma Ada_95;
pragma Source_File_Name (ada_main, Spec_File_Name => "b~ima.ads");
pragma Source_File_Name (ada_main, Body_File_Name => "b~ima.adb");
pragma Suppress (Overflow_Check);
with Ada.Exceptions;

package body ada_main is

   E011 : Short_Integer; pragma Import (Ada, E011, "ada__exceptions_E");
   E015 : Short_Integer; pragma Import (Ada, E015, "system__soft_links_E");
   E025 : Short_Integer; pragma Import (Ada, E025, "system__exception_table_E");
   E027 : Short_Integer; pragma Import (Ada, E027, "system__exceptions_E");
   E017 : Short_Integer; pragma Import (Ada, E017, "system__soft_links__initialize_E");
   E059 : Short_Integer; pragma Import (Ada, E059, "ada__io_exceptions_E");
   E161 : Short_Integer; pragma Import (Ada, E161, "ada__strings_E");
   E212 : Short_Integer; pragma Import (Ada, E212, "interfaces__c_E");
   E216 : Short_Integer; pragma Import (Ada, E216, "interfaces__c__strings_E");
   E082 : Short_Integer; pragma Import (Ada, E082, "system__os_lib_E");
   E061 : Short_Integer; pragma Import (Ada, E061, "ada__tags_E");
   E058 : Short_Integer; pragma Import (Ada, E058, "ada__streams_E");
   E085 : Short_Integer; pragma Import (Ada, E085, "system__file_control_block_E");
   E080 : Short_Integer; pragma Import (Ada, E080, "system__finalization_root_E");
   E078 : Short_Integer; pragma Import (Ada, E078, "ada__finalization_E");
   E077 : Short_Integer; pragma Import (Ada, E077, "system__file_io_E");
   E127 : Short_Integer; pragma Import (Ada, E127, "system__storage_pools_E");
   E121 : Short_Integer; pragma Import (Ada, E121, "system__finalization_masters_E");
   E210 : Short_Integer; pragma Import (Ada, E210, "ada__calendar_E");
   E056 : Short_Integer; pragma Import (Ada, E056, "ada__text_io_E");
   E163 : Short_Integer; pragma Import (Ada, E163, "ada__strings__maps_E");
   E166 : Short_Integer; pragma Import (Ada, E166, "ada__strings__maps__constants_E");
   E129 : Short_Integer; pragma Import (Ada, E129, "system__pool_global_E");
   E206 : Short_Integer; pragma Import (Ada, E206, "arrondis_E");
   E191 : Short_Integer; pragma Import (Ada, E191, "ma_lexico_dfa_E");
   E193 : Short_Integer; pragma Import (Ada, E193, "ma_lexico_io_E");
   E113 : Short_Integer; pragma Import (Ada, E113, "types_base_E");
   E208 : Short_Integer; pragma Import (Ada, E208, "clocks_E");
   E195 : Short_Integer; pragma Import (Ada, E195, "lecture_entiers_E");
   E218 : Short_Integer; pragma Import (Ada, E218, "lecture_flottants_E");
   E111 : Short_Integer; pragma Import (Ada, E111, "mes_tables_E");
   E197 : Short_Integer; pragma Import (Ada, E197, "options_E");
   E133 : Short_Integer; pragma Import (Ada, E133, "pseudo_code_E");
   E156 : Short_Integer; pragma Import (Ada, E156, "pseudo_code__table_E");
   E109 : Short_Integer; pragma Import (Ada, E109, "ma_detiq_E");
   E173 : Short_Integer; pragma Import (Ada, E173, "ma_syntax_tokens_E");
   E172 : Short_Integer; pragma Import (Ada, E172, "ma_syntax_shift_reduce_E");
   E183 : Short_Integer; pragma Import (Ada, E183, "ma_dict_E");
   E181 : Short_Integer; pragma Import (Ada, E181, "ma_lexico_E");
   E170 : Short_Integer; pragma Import (Ada, E170, "ma_syntax_E");
   E107 : Short_Integer; pragma Import (Ada, E107, "assembleur_E");
   E223 : Short_Integer; pragma Import (Ada, E223, "utf8_es_E");
   E200 : Short_Integer; pragma Import (Ada, E200, "partie_op_E");
   E220 : Short_Integer; pragma Import (Ada, E220, "partie_op__temps_E");

   Sec_Default_Sized_Stacks : array (1 .. 1) of aliased System.Secondary_Stack.SS_Stack (System.Parameters.Runtime_Default_Sec_Stack_Size);

   Local_Priority_Specific_Dispatching : constant String := "";
   Local_Interrupt_States : constant String := "";

   Is_Elaborated : Boolean := False;

   procedure finalize_library is
   begin
      E129 := E129 - 1;
      declare
         procedure F1;
         pragma Import (Ada, F1, "system__pool_global__finalize_spec");
      begin
         F1;
      end;
      E056 := E056 - 1;
      declare
         procedure F2;
         pragma Import (Ada, F2, "ada__text_io__finalize_spec");
      begin
         F2;
      end;
      E121 := E121 - 1;
      declare
         procedure F3;
         pragma Import (Ada, F3, "system__finalization_masters__finalize_spec");
      begin
         F3;
      end;
      declare
         procedure F4;
         pragma Import (Ada, F4, "system__file_io__finalize_body");
      begin
         E077 := E077 - 1;
         F4;
      end;
      declare
         procedure Reraise_Library_Exception_If_Any;
            pragma Import (Ada, Reraise_Library_Exception_If_Any, "__gnat_reraise_library_exception_if_any");
      begin
         Reraise_Library_Exception_If_Any;
      end;
   end finalize_library;

   procedure adafinal is
      procedure s_stalib_adafinal;
      pragma Import (Ada, s_stalib_adafinal, "system__standard_library__adafinal");

      procedure Runtime_Finalize;
      pragma Import (C, Runtime_Finalize, "__gnat_runtime_finalize");

   begin
      if not Is_Elaborated then
         return;
      end if;
      Is_Elaborated := False;
      Runtime_Finalize;
      s_stalib_adafinal;
   end adafinal;

   type No_Param_Proc is access procedure;
   pragma Favor_Top_Level (No_Param_Proc);

   procedure adainit is
      Main_Priority : Integer;
      pragma Import (C, Main_Priority, "__gl_main_priority");
      Time_Slice_Value : Integer;
      pragma Import (C, Time_Slice_Value, "__gl_time_slice_val");
      WC_Encoding : Character;
      pragma Import (C, WC_Encoding, "__gl_wc_encoding");
      Locking_Policy : Character;
      pragma Import (C, Locking_Policy, "__gl_locking_policy");
      Queuing_Policy : Character;
      pragma Import (C, Queuing_Policy, "__gl_queuing_policy");
      Task_Dispatching_Policy : Character;
      pragma Import (C, Task_Dispatching_Policy, "__gl_task_dispatching_policy");
      Priority_Specific_Dispatching : System.Address;
      pragma Import (C, Priority_Specific_Dispatching, "__gl_priority_specific_dispatching");
      Num_Specific_Dispatching : Integer;
      pragma Import (C, Num_Specific_Dispatching, "__gl_num_specific_dispatching");
      Main_CPU : Integer;
      pragma Import (C, Main_CPU, "__gl_main_cpu");
      Interrupt_States : System.Address;
      pragma Import (C, Interrupt_States, "__gl_interrupt_states");
      Num_Interrupt_States : Integer;
      pragma Import (C, Num_Interrupt_States, "__gl_num_interrupt_states");
      Unreserve_All_Interrupts : Integer;
      pragma Import (C, Unreserve_All_Interrupts, "__gl_unreserve_all_interrupts");
      Exception_Tracebacks : Integer;
      pragma Import (C, Exception_Tracebacks, "__gl_exception_tracebacks");
      Detect_Blocking : Integer;
      pragma Import (C, Detect_Blocking, "__gl_detect_blocking");
      Default_Stack_Size : Integer;
      pragma Import (C, Default_Stack_Size, "__gl_default_stack_size");
      Default_Secondary_Stack_Size : System.Parameters.Size_Type;
      pragma Import (C, Default_Secondary_Stack_Size, "__gnat_default_ss_size");
      Bind_Env_Addr : System.Address;
      pragma Import (C, Bind_Env_Addr, "__gl_bind_env_addr");

      procedure Runtime_Initialize (Install_Handler : Integer);
      pragma Import (C, Runtime_Initialize, "__gnat_runtime_initialize");

      Finalize_Library_Objects : No_Param_Proc;
      pragma Import (C, Finalize_Library_Objects, "__gnat_finalize_library_objects");
      Binder_Sec_Stacks_Count : Natural;
      pragma Import (Ada, Binder_Sec_Stacks_Count, "__gnat_binder_ss_count");
      Default_Sized_SS_Pool : System.Address;
      pragma Import (Ada, Default_Sized_SS_Pool, "__gnat_default_ss_pool");

   begin
      if Is_Elaborated then
         return;
      end if;
      Is_Elaborated := True;
      Main_Priority := -1;
      Time_Slice_Value := -1;
      WC_Encoding := 'b';
      Locking_Policy := ' ';
      Queuing_Policy := ' ';
      Task_Dispatching_Policy := ' ';
      Priority_Specific_Dispatching :=
        Local_Priority_Specific_Dispatching'Address;
      Num_Specific_Dispatching := 0;
      Main_CPU := -1;
      Interrupt_States := Local_Interrupt_States'Address;
      Num_Interrupt_States := 0;
      Unreserve_All_Interrupts := 0;
      Exception_Tracebacks := 1;
      Detect_Blocking := 0;
      Default_Stack_Size := -1;

      ada_main'Elab_Body;
      Default_Secondary_Stack_Size := System.Parameters.Runtime_Default_Sec_Stack_Size;
      Binder_Sec_Stacks_Count := 1;
      Default_Sized_SS_Pool := Sec_Default_Sized_Stacks'Address;

      Runtime_Initialize (1);

      Finalize_Library_Objects := finalize_library'access;

      Ada.Exceptions'Elab_Spec;
      System.Soft_Links'Elab_Spec;
      System.Exception_Table'Elab_Body;
      E025 := E025 + 1;
      System.Exceptions'Elab_Spec;
      E027 := E027 + 1;
      System.Soft_Links.Initialize'Elab_Body;
      E017 := E017 + 1;
      E015 := E015 + 1;
      E011 := E011 + 1;
      Ada.Io_Exceptions'Elab_Spec;
      E059 := E059 + 1;
      Ada.Strings'Elab_Spec;
      E161 := E161 + 1;
      Interfaces.C'Elab_Spec;
      E212 := E212 + 1;
      Interfaces.C.Strings'Elab_Spec;
      E216 := E216 + 1;
      System.Os_Lib'Elab_Body;
      E082 := E082 + 1;
      Ada.Tags'Elab_Spec;
      Ada.Tags'Elab_Body;
      E061 := E061 + 1;
      Ada.Streams'Elab_Spec;
      E058 := E058 + 1;
      System.File_Control_Block'Elab_Spec;
      E085 := E085 + 1;
      System.Finalization_Root'Elab_Spec;
      E080 := E080 + 1;
      Ada.Finalization'Elab_Spec;
      E078 := E078 + 1;
      System.File_Io'Elab_Body;
      E077 := E077 + 1;
      System.Storage_Pools'Elab_Spec;
      E127 := E127 + 1;
      System.Finalization_Masters'Elab_Spec;
      System.Finalization_Masters'Elab_Body;
      E121 := E121 + 1;
      Ada.Calendar'Elab_Spec;
      Ada.Calendar'Elab_Body;
      E210 := E210 + 1;
      Ada.Text_Io'Elab_Spec;
      Ada.Text_Io'Elab_Body;
      E056 := E056 + 1;
      Ada.Strings.Maps'Elab_Spec;
      E163 := E163 + 1;
      Ada.Strings.Maps.Constants'Elab_Spec;
      E166 := E166 + 1;
      System.Pool_Global'Elab_Spec;
      E129 := E129 + 1;
      Arrondis'Elab_Spec;
      E206 := E206 + 1;
      E191 := E191 + 1;
      MA_LEXICO_IO'ELAB_SPEC;
      E193 := E193 + 1;
      E113 := E113 + 1;
      Clocks'Elab_Body;
      E208 := E208 + 1;
      E195 := E195 + 1;
      E218 := E218 + 1;
      E111 := E111 + 1;
      Options'Elab_Body;
      E197 := E197 + 1;
      Pseudo_Code'Elab_Spec;
      Pseudo_Code.Table'Elab_Spec;
      Pseudo_Code.Table'Elab_Body;
      E156 := E156 + 1;
      Pseudo_Code'Elab_Body;
      E133 := E133 + 1;
      ma_detiq'elab_spec;
      MA_DETIQ'ELAB_BODY;
      E109 := E109 + 1;
      Ma_Syntax_Tokens'Elab_Spec;
      E173 := E173 + 1;
      Ma_Syntax_Shift_Reduce'Elab_Spec;
      E172 := E172 + 1;
      Ma_Dict'Elab_Body;
      E183 := E183 + 1;
      ma_lexico'elab_spec;
      MA_LEXICO'ELAB_BODY;
      E181 := E181 + 1;
      E170 := E170 + 1;
      Assembleur'Elab_Spec;
      E107 := E107 + 1;
      E223 := E223 + 1;
      Partie_Op'Elab_Spec;
      E220 := E220 + 1;
      Partie_Op'Elab_Body;
      E200 := E200 + 1;
   end adainit;

   procedure Ada_Main_Program;
   pragma Import (Ada, Ada_Main_Program, "_ada_ima");

   function main
     (argc : Integer;
      argv : System.Address;
      envp : System.Address)
      return Integer
   is
      procedure Initialize (Addr : System.Address);
      pragma Import (C, Initialize, "__gnat_initialize");

      procedure Finalize;
      pragma Import (C, Finalize, "__gnat_finalize");
      SEH : aliased array (1 .. 2) of Integer;

      Ensure_Reference : aliased System.Address := Ada_Main_Program_Name'Address;
      pragma Volatile (Ensure_Reference);

   begin
      if gnat_argc = 0 then
         gnat_argc := argc;
         gnat_argv := argv;
      end if;
      gnat_envp := envp;

      Initialize (SEH'Address);
      adainit;
      Ada_Main_Program;
      adafinal;
      Finalize;
      return (gnat_exit_status);
   end;

--  BEGIN Object file/option list
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/arrondis.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/config_machine.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_lexico_dfa.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_lexico_io.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_syntax_goto.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/types_base.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/clocks.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/entier_es.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/flottant_es.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/lecture_entiers.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/lecture_flottants.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/mes_tables.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/options.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/pseudo_code-table.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/pseudo_code.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_detiq.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_syntax_tokens.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_syntax_shift_reduce.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_token_io.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_dict.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_lexico.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ma_syntax.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/assembleur.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/utf8_es.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/partie_op-temps.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/partie_op.o
   --   /Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/ima.o
   --   -L/Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/
   --   -L/Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/Obj/
   --   -L/Users/victor/Developer/ensimag/GL/global/sources/Machine_Abstraite/L_Interp/Src/../..//Commun/Obj/
   --   -L/Users/victor/opt/GNAT/2020/lib/gcc/x86_64-apple-darwin17.7.0/8.4.1/adalib/
   --   -static
   --   -lgnat
--  END Object file/option list   

end ada_main;
