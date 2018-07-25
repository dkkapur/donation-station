// UserInfo.js
import React from 'react'
import { StyleSheet, Text, TextInput, View, Button, TouchableOpacity } from 'react-native'
import RNGooglePlaces from 'react-native-google-places';

import firebase from 'react-native-firebase'
export default class UserInfo extends React.Component {
  state = { currentUser: null, place: null }
  render() {
    return (
      <View style={styles.container}>
        <Text>Your info</Text>
        <Text>We need this so we can know more about you :)</Text>
        {this.state.errorMessage &&
          <Text style={{ color: 'red' }}>
            {this.state.errorMessage}
          </Text>}
          
        <Button
          title="Input your location"
          onPress={() => this.openSearchModal()}
        />

        <TextInput
          placeholder="Phone Number"
          autoCapitalize="none"
          style={styles.textInput}
          //onChangeText={password => this.setState({ password })}
          //value={this.state.password}
        />
        <Button title="Done!" onPress={() => this.props.navigation.navigate('Main')} />
      </View>
    )
  }

  componentDidMount() {
    const { currentUser } = firebase.auth()
    this.setState({ currentUser })
  }

  openSearchModal() {
    RNGooglePlaces.openAutocompleteModal()
    .then((place) => {
      this.setState({place: JSON.stringify(place)})
    })
    .catch(error => console.log(error.message)); 
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
  },
  button: {
    backgroundColor: '#263238',
    flexDirection: 'row',
    height: 45,
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 10
  }
})