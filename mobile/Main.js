// Main.js
import React from 'react'
        import {
        StyleSheet, Platform, Image, Button, View,
                ScrollView,
                TouchableHighlight,
                ListView } from 'react-native'
        import firebase from 'react-native-firebase'

import {
Text,
        Card,
        ButtonGroup,
        Tile,
        Icon,
        ListItem,
        Avatar,
} from 'react-native-elements';

export default class Main extends React.Component {
    state = {currentUser: null}
    render() {
        const {currentUser} = this.state
        return (
                <ScrollView>
                    <View style={styles.headerContainer}>
                        <Icon color="white" name="invert-colors" size={62} />
                        <Text style={styles.heading}>Events Near Me</Text>
                    </View>
                    <View style={styles.container}>
                        <Text>
                        Hi {currentUser && currentUser.email}!
                        </Text>
                
                        <Button style={styles.topBar} onPress={this.logout.bind(this)}
                                title="Log Out"
                                />
                
                    </View>
                </ScrollView>
                )
    }

    componentDidMount() {
        const {currentUser} = firebase.auth()
        this.setState({currentUser})
    }

    logout() {
        firebase.auth().signOut().then(() => {
            this.setState({currentUser: null})
        });
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'pink'
    },

    topBar: {
        backgroundColor: 'pink'
    },

    headerContainer: {
        justifyContent: 'center',
        alignItems: 'center',
        padding: 40,
        backgroundColor: '#FD6B78',
    },
    heading: {
        color: 'white',
        marginTop: 10,
        fontSize: 22,
    }
})