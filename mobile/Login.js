// Login.js
import React from 'react'
import { StyleSheet, Text, TextInput, View } from 'react-native'
import firebase from 'react-native-firebase'
import { FormLabel, FormInput, Card, Button } from 'react-native-elements'
import { styles } from './styling';
export default class Login extends React.Component {
  state = { email: '', password: '', errorMessage: null }

  handleLogin = () => {
    if (!this.state.email || this.state.email === "") 
    {
      this.setState({errorMessage: "Please input an email address"})
      return
    }

    if (!this.state.password || this.state.password === "") 
    {
      this.setState({errorMessage: "Please input a password"})
      return
    }
    
    const { email, password } = this.state
    firebase
      .auth()
      .signInAndRetrieveDataWithEmailAndPassword(email, password)
      .then(() => this.props.navigation.navigate('Main'))
      .catch(error => this.setState({ errorMessage: error.message }))
  }

  render() {
    return (
      <View style={styles.container}>
        <Card title='Login'
              containerStyle={styles.centerCard}
              titleStyle={{fontSize: 24}}>
          <FormLabel>Name</FormLabel>
          <FormInput
          style={styles.textInput}
          autoCapitalize="none"
          placeholder="Email"
          onChangeText={email => this.setState({ email })}
          value={this.state.email}/>
          {this.state.errorMessage &&
          <FormLabel style={{ color: 'red' }}>
            {this.state.errorMessage}
          </FormLabel>}
          <FormInput
            secureTextEntry
            style={styles.textInput}
            autoCapitalize="none"
            placeholder="Password"
            onChangeText={password => this.setState({ password })}
            value={this.state.password}
          />
          <Button title="Login" onPress={this.handleLogin} style={{ color: 'red' }}
                  buttonStyle={styles.primaryButton}
          />
          <Button
            title="Don't have an account? Sign Up"
            onPress={() => this.props.navigation.navigate('SignUp')}
            buttonStyle={styles.secondaryButton}
          />
        </Card>
      </View>
    )
  }
}
