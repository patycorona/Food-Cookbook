package com.example.foodcookbook.repository

import com.example.foodcookbook.api.CoreHomeApi
import com.example.foodcookbook.mapping.toModel
import com.example.foodcookbook.models.*
import io.reactivex.Single
import javax.inject.Inject


class RecipeBookRepository @Inject constructor(
    private  val apiService : CoreHomeApi
){

  /*  fun getRecipebooks(): Single<ArrayList<RecipeBook>>
    {
        var listRecipebook: ArrayList<RecipeBook> = arrayListOf()
        listRecipebook.add(RecipeBook(idRecipebook = 0,nameRecipebook= "Orange chicken", productPhoto = R.drawable.orange_chicken, author = "Mario López", recipeBook = "*Pechuga de pollo," +
                "\n" + "*vinagre, " +
                "\n" + "*Harina, " +
                "\n" + "*Maizena," +
                "\n" + "*Colorante vegetal rojo," +
                "\n" + "y mucha pero mucha Azucar",
            "2022-02-16T21:14:14.804634"))
        listRecipebook.add(RecipeBook(idRecipebook = 1,nameRecipebook= "Pozole rojo", productPhoto = R.drawable.pozole, author = "Juana palmiraz", recipeBook = "En México es usual comer esta sopa por las noches, y es clásica en las fiestas patrias o durante las frías noches de invierno; aunque algunas familias también preparan este delicioso platillo durante las celebraciones de fin de año.\n" +
                "\n" +
                "El pozole original se prepara con maíz cacahuazintle seco y con parte de la cabeza del puerco. El maíz seco agrega un sabor incomparable a esta sopa, pero hoy en día es más común que se use como sustituto el maíz que se vende en lata, por la conveniencia de que ya está cocido.\n" +
                "\n" +
                "Pozole rojo receta - Una de las mejores recetas de Pozole rojo en el internet","2022-02-16T21:14:14.804634"))
        listRecipebook.add(RecipeBook(idRecipebook = 2,nameRecipebook= "Risotto de pollo",productPhoto = R.drawable.risotto, author = "Alessandro Bojorquez", recipeBook = "Ingredientes\n" +
                "1 Cucharadita Aceite De Oliva\n" +
                "4 Dientes Ajo Cortados finamente\n" +
                "(75 g.) 1/2 Taza Cebolla Cortada finamente\n" +
                "1/2 Taza Apio Cortado finamente\n" +
                "(100 g.) 3/4 Taza Pimentón Rojo Cortado finamente\n" +
                "1/4 Taza Aceitunas Rebanadas\n" +
                "(280 g.) 1 3/4 Taza Pechuga De Pollo Cocida y deshilachada\n" +
                "1/2 Taza Vino Blanco\n" +
                "1 Taza Arroz arbório Crudo\n" +
                "(10 g.) 1 Sobre Consomé De Pollo Maggi®\n" +
                "2 1/2 cups Agua Mineral San Pellegrino®\n" +
                "1/2 Taza Crema De Leche Nestlé®","2022-02-16T21:14:14.804634"))
        listRecipebook.add(RecipeBook(idRecipebook = 3,nameRecipebook= "Medias de ceda", productPhoto = R.drawable.medias_ceda, author = "Diana Castillo", recipeBook = "¿Sabías que las medias de seda es un cóctel del cual se desconoce su origen? Se piensa que probablemente haya surgido después de la Segunda Guerra Mundial, cuando las señoritas de las grandes ciudades aún usaban medias de seda, antes de que cayeran en desuso por la introducción del Nylon.\n" +
                "\n" +
                "Se trata de una bebida muy sencilla preparada con ron, leche condensada, crema de leche y un poco de granadina, te decimos cómo hacer medias de seda en casa, ¡toma nota!\n" +
                "\n" +
                "Ingredientes:\n" +
                "\n" +
                "1 oz (30 ml) de ginebra\n" +
                "2 oz (60 ml) de leche evaporada\n" +
                "4 oz (120 ml) de granadina\n" +
                "1 cucharadita de canela en polvo\n" +
                "1 cereza\n" +
                "3 hielos","2022-02-16T21:14:14.804634"))

        return Single.just(listRecipebook)
    }*/

   fun getRecipebooks(): Single<MutableList<RecipeBook>> {
       return apiService.getRecipebook()
           .map { recipeBook ->
               recipeBook.toModel()
           }
   }

    fun userAccess(user:String,password:String,userId:String): Single<AccessResultModel> {
        return apiService.userAccess(
            userAccessRequest = UserAccessRequest(
                email = user,
                password = password,
                userid = userId
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }


}