import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.reisalazar.jogodavelha.navigation.AppScreens
import com.example.reisalazar.jogodavelha.screen.InitialScreen

@Composable
fun GameNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.InitialScreen.name
    ) {

        composable(AppScreens.InitialScreen.name) {
            InitialScreen()
        }
        composable(
            AppScreens.HistoryScreen.name + "/{game}",
            arguments = listOf(navArgument(name = "game"){type= NavType.StringType})
        ) {
                backStackEntry ->
//            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}