import { StyleSheet } from 'react-native'

const primary = '#fc624e';
const secondary = '#fc624e';
const tertiary = '#ce9429';

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: primary
  },
  textInput: {
    height: 40,
    width: '90%',
    borderColor: 'gray',
    borderWidth: 1,
    marginTop: 8
  },
  centerCard: {
    height: '60%',
    width: '80%',
    borderRadius: 5
  },
  LargeCenterCard: {
    height: '90%',
    width: '80%',
    borderRadius: 5
  },
  primaryButton: {
    borderRadius: 5,
    marginLeft: 0,
    marginRight: 0,
    marginBottom: 10,
    backgroundColor: secondary
  },
  secondaryButton: {
    borderRadius: 5,
    marginLeft: 0,
    marginRight: 0,
    marginBottom: 10,
    backgroundColor: tertiary
  }
});
