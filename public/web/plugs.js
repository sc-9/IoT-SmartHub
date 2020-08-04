/**
 * The Plugs controller holds the state of plugs.
 * It refreshes the state every 1 second (and notify the parent controller).
 * It creates its view in render().
 */
class Plugs extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			plugs: []
		};
	}

	updatePlugs(plugs) {
		if (!Array.isArray(plugs)) {
			console.debug("Plugs: cannot get plugs " + JSON.stringify(plugs));
			return;
		}

		console.debug("Plugs: " + JSON.stringify(plugs));

		this.setState({ plugs: plugs });

		if (this.props.plugSelected == null)
			return;

		// notify parent
		for (var i = 0; i < plugs.length; ++i) {
			if (this.props.plugSelected.name == plugs[i].name) {
				this.props.updatePlugSelected(plugs[i]);
				return;
			}
		}
	}

	getPlugs() {
		fetch("../api/plugs")
			.then(rsp => rsp.json())
			.then(data => this.updatePlugs(data))
			.catch(err => console.debug("Plugs: error " + JSON.stringify(err)));
	}

	componentDidMount() {
		this.getPlugs();
		window.setInterval(() => this.getPlugs(), 1000);
	}

	render() {
		return (<PlugsView
			plugs={this.state.plugs}
			plugSelected={this.props.plugSelected}
			selectPlug={this.props.updatePlugSelected} />);
	}
}

window.Plugs = Plugs;
