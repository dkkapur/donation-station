// SignUp.js
import React from 'react'
import { Text, TextInput, View } from 'react-native'
import { FormLabel, FormInput, Card, Button } from 'react-native-elements'

import firebase from 'react-native-firebase'
import { styles } from './styling';
export default class SignUp extends React.Component {
  state = { email: '', password: '', errorMessage: null }
handleSignUp = () => {
    firebase
      .auth()
      .createUserWithEmailAndPassword(this.state.email, this.state.password)
      .then(() => this.props.navigation.navigate('Main'))
      .catch(error => this.setState({ errorMessage: error.message }))
}
render() {
    return (
      <View style={styles.container}>
        <Card title='Sign Up'
              containerStyle={styles.centerCard}
              titleStyle={{fontSize: 24}}>
          {this.state.errorMessage &&
          <Text style={{ color: 'red' }}>
            {this.state.errorMessage}
          <FormLabel>Email</FormLabel>
          </Text>}
          <FormInput
            placeholder="Email"
            autoCapitalize="none"
            style={styles.textInput}
            onChangeText={email => this.setState({ email })}
            value={this.state.email}
          />
          <FormInput
            secureTextEntry
            style={styles.textInput}
            autoCapitalize="none"
            placeholder="Password"
            onChangeText={password => this.setState({ password })}
            value={this.state.password}
          />
          <Button title="Sign Up" onPress={this.handleSignUp}
                  buttonStyle={styles.primaryButton}
          />
          <Button
            title="Already have an account? Login"
            onPress={() => this.props.navigation.navigate('Login')}
            buttonStyle={styles.secondaryButton}
          />
        </Card>
      </View>
    )
  }
}
