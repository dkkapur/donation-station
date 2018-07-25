// Main.js
import React from 'react'
import { StyleSheet, Platform, Image, Text, View, Button } from 'react-native'
import firebase from 'react-native-firebase'
export default class Main extends React.Component {
  state = { currentUser: null }
render() {
    const { currentUser } = this.state
return (
      <View style={styles.container}>
        <Text>
          Hi {currentUser && currentUser.email}!
        </Text>

        <Button onPress={this.logout.bind(this)}
          title="Log Out"
        />

      </View>
    )
  }

  componentDidMount() {
    const { currentUser } = firebase.auth()
    this.setState({ currentUser })
  }

  logout() {
    firebase.auth().signOut().then(() => {
      this.setState({ currentUser: null} )
        });
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  }
})