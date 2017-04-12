import React, { Component } from 'react'
import {
  NativeModules,
  Text,
  View
} from 'react-native';

const MeuConsole = NativeModules.MeuConsole;

class MeuComponente extends Component {

    constructor(props){
        super(props);
        MeuConsole.log("constructor")
    }

    componentWillMount() {
        MeuConsole.log("componenteWillMount")
    }

    componentDidMount() {
        MeuConsole.log("componenteDidMount")
    }

    render () {
        return (
            <View>
                <Text>Este é o meu componente no {this.props.plataforma}!</Text>
            </View>
        )
    }
}

export default MeuComponente