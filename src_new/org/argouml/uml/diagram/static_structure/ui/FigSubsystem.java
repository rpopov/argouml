// $Id$
// Copyright (c) 1996-2005 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

// $Id$

package org.argouml.uml.diagram.static_structure.ui;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;

import org.argouml.model.Model;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigPoly;

/** Class to display graphics for a UML subsystem in a class diagram. */

public class FigSubsystem extends FigPackage {

    private FigPoly figPoly = new FigPoly(Color.black, Color.black);

    /**
     * The main Constructor.
     */
    public FigSubsystem() {
        super();

        int[] xpoints = {125, 125, 130, 130, 130, 135, 135};
        int[] ypoints = {45, 40, 40, 35, 40, 40, 45};
        Polygon polygon = new Polygon(xpoints, ypoints, 7);
        figPoly.setPolygon(polygon);
        figPoly.setFilled(false);
        addFig(figPoly);
        Rectangle r = getBounds();
        setBounds(r.x, r.y, r.width, r.height);
        updateEdges();
    }

    /**
     * Constructor that hooks the Fig to a UML element
     * @param gm ignored
     * @param node the UML element
     */
    public FigSubsystem(GraphModel gm, Object node) {
        this();
        setOwner(node);

        if (Model.getFacade().isASubsystem(node)
                && (Model.getFacade().getName(node) != null)) {
            getNameFig().setText(Model.getFacade().getName(node));
        }
    }

    /**
     * @see org.tigris.gef.presentation.Fig#setBounds(int, int, int, int)
     */
    public void setBounds(int x, int y, int w, int h) {

        if (figPoly != null) {
            Rectangle oldBounds = getBounds();
            Rectangle polyBounds = figPoly.getBounds();
            ;
            figPoly.translate((x - oldBounds.x) + (w - oldBounds.width), y
                    - oldBounds.y);

        }
        super.setBounds(x, y, w, h);
    }

    /**
     * @see org.argouml.uml.diagram.ui.FigNodeModelElement#placeString()
     */
    public String placeString() {
        return "new Subsystem";
    }

} /* end class FigSubsystem */
