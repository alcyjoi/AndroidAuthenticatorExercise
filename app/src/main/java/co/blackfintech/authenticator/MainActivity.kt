package co.blackfintech.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import co.blackfintech.authenticator.util.SessionStore
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }


  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)

    return true

  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean
  {
    // listen for onclick event of the menu items
    when(item?.itemId) {
      R.id.action_logout -> {

        logout()

      }
    }
    return true
  }
  fun logout() {
    alert ("Are you sure you want to logout?") {
      yesButton {
       val session = SessionStore()
        session.clearEmail(this@MainActivity)

        startActivity<LoginActivity>()

        finish()
      }
    }.show()
  }
  }


