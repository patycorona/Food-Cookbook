package com.example.foodcookbook.views.component

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

// configuracion del datepicker fragmente  hacer clase dentro del component y poner esto
class DatePickerFragment(val listener: (year:Int, month:Int, day:Int) -> Unit):
    DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR) -18
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // esta configurado para que por default nos devuelva la fecha actual
        return DatePickerDialog(requireActivity(),this, year, month, day)
    }

    override fun onDateSet(p0: android.widget.DatePicker?, year:Int, month:Int, day:Int) {
        listener(year,month+1,day)
    }
}