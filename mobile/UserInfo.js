// UserInfo.js
import React from 'react'
import { StyleSheet, Platform, Image, Text, TextInput, View, Button } from 'react-native'
import firebase from 'react-native-firebase'
export default class UserInfo extends React.Component {
  state = { currentUser: null }
  render() {
    return (
    <View style={styles.container}>
      <Card title='Your info'
            containerStyle={styles.centerCard}
            titleStyle={{fontSize: 24}}>
        <Text>We need this so we can know more about you :)</Text>
        {this.state.errorMessage &&
        <Text style={{ color: 'red' }}>
          {this.state.errorMessage}
        </Text>}
        <FormLabel>Location</FormLabel>
        <FormInput
          placeholder="Location"
          autoCapitalize="none"
          style={styles.textInput}
          //onChangeText={email => this.setState({ email })}
          //value={this.state.email}
        />
        <FormLabel>Phone Number</FormLabel>
        <FormInput
          placeholder="Phone Number"
          autoCapitalize="none"
          style={styles.textInput}
          //onChangeText={password => this.setState({ password })}
          //value={this.state.password}
        />
        <Button title="Done!" onPress={() => this.props.navigation.navigate('Main')}
                buttonStyle={styles.primaryButton}
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

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },
  textInput: {
    height: 40,
    width: '90%',
    borderColor: 'gray',
    borderWidth: 1,
    marginTop: 8
  }
})
