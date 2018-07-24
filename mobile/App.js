import React from 'react'
import { StyleSheet, Platform, Image, Text, View } from 'react-native'
import { SwitchNavigator } from 'react-navigation'
// import the different screens
import Loading from './Loading'
import SignUp from './SignUp'
import UserInfo from "./UserInfo"
import Login from './Login'
import Main from './Main'
// create our app's navigation stack
const App = SwitchNavigator(
  {
    Loading,
    SignUp,
    UserInfo,
    Login,
    Main,
  },
  {
    initialRouteName: 'Loading'
  }
)
export default App