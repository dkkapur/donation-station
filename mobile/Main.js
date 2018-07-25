// Main.js
import React from 'react'
import { StyleSheet, Platform, Image, Text, View } from 'react-native'
import firebase from 'react-native-firebase'
import { Button, Card } from 'react-native-elements'
import { styles } from './styling';

export default class Main extends React.Component {
  state = { currentUser: null }
render() {
    const { currentUser } = this.state
return (
      <View style={styles.container}>

        <Card title='Home'
          containerStyle={styles.LargeCenterCard}
          titleStyle={{fontSize: 24}}>
          <Text>
            Hi {currentUser && currentUser.email}!
          </Text>

          <Button
            title="settings"
            onPress={() => this.props.navigation.navigate('UserInfo')}
            buttonStyle={styles.secondaryButton}
          />
          <Button onPress={this.logout.bind(this)}
                  title="Log Out"
                  buttonStyle={styles.secondaryButton}
          />
        </Card>
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

